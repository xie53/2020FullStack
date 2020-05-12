package com.ibm.business;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Collections;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.ibm.business.interceptor.ClientResponseErrorHandler;
import com.ibm.business.interceptor.LogClientHttpRequestInterceptor;


@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate(@Value("${remote.http.connect.timeout}") int connectTimeout,
			@Value("${remote.http.read.timeout}") int readTimeout,
			@Value("${remote.http.ssl.enabled}") String sslEnabled)
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

		boolean isSSLValidationIgnore = "false".equals(sslEnabled);
		DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy() {
			@Override
			public boolean isRedirected(org.apache.http.HttpRequest request, org.apache.http.HttpResponse response,
				org.apache.http.protocol.HttpContext context) throws org.apache.http.ProtocolException {
				return false;

			}
		};

		CloseableHttpClient httpclient;
		if (isSSLValidationIgnore) {
			SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
			TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
						@Override
						public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
								throws CertificateException {							
						}
						@Override
						public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
								throws CertificateException {
						}
						@Override
						public java.security.cert.X509Certificate[] getAcceptedIssuers() {
							return null;
						}
                    }
            };
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
			httpclient = HttpClients.custom().setRedirectStrategy(redirectStrategy).setSSLContext(sslContext)
					.setSSLHostnameVerifier(hostnameVerifier).build();
		} else {
			httpclient = HttpClients.custom().setRedirectStrategy(redirectStrategy).build();
		}
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpclient);
		RestTemplate restTemplate = new RestTemplate();
		factory.setConnectTimeout(connectTimeout);
		factory.setReadTimeout(readTimeout);
        // レスポンスボディを繰り返しRead可能させること
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(factory));
		// 外部Apiへの通信・受信内容をログ
		restTemplate.setInterceptors(Collections.singletonList(new LogClientHttpRequestInterceptor()));
		// エラーハンドリング
		restTemplate.setErrorHandler(new ClientResponseErrorHandler());
		return restTemplate;
	}
}
