import {Category} from './category';

export interface HopDong {
  id: number;
  maDat: string;
  maNguoiBan: string;
  ngayBatDau: string;
  ngayKetThuc: string;
  diaChi: string;
  gia: string;
  category: Category;
}
