import { Injectable } from '@angular/core';
import { Product } from 'src/app/model/product.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = 'http://localhost:8080/api/v1/product';

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/products`);
  }

<<<<<<< HEAD
  deleteProduct(): Observable<Product[]> {
    return this.http.delete<Product[]>(`${this.apiUrl}/products/{id}`);
=======
  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/products/${id}`, { responseType: 'text' });
>>>>>>> feature/product-delete
  }
}
