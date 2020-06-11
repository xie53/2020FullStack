export interface Product {
  id: number;
  imageUrl: string;
  title: string;
  tags: string[];
  price: number;
  priceDesc: string;
}

export interface ItemTemp {
  itemName: string;
  stockNumber: number;
  remainNumber: number;
}

export interface Item {
  id: string;
  itemName: string;
  categoryId: string;
  subcategoryId: string;
  price: number;
  description: string;
  stockNumber: number;
  remainNumber: number;
  remarks: string;
}
