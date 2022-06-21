import {DiaDiem} from './dia-diem';

export interface PhuongTien {
  id: number;
  bienSoXe: string;
  loaiXe: string;
  tenNhaXe: string;
  diemDi: DiaDiem;
  diemDen: DiaDiem;
  soDienThoai: string;
  email: string;
  gioDi: string;
  gioDen: string;
}
