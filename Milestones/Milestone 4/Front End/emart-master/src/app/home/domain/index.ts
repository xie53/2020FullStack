export interface Manufacturer {
  name: string;
  id: number;
}

export interface SearchItem {
  startPrice: string;
  endPrice: string;
  manufacturer: string;
}

export interface ImageSlider {
  id: number;
  imgUrl: string;
  link: string;
}
