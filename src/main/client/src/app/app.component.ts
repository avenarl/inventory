import { Component, OnInit } from '@angular/core';
import { ProductService } from './service/product/product.service';
import { Product } from './model/product.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'client';
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
      this.getProducts();
  }

  getProducts() {
    this.productService.getProducts().subscribe((products: Product[]) => {
      this.products = products;
    })
  }

  deleteProducts() {
    this.productService.deleteProduct().subscribe((products: Product[]) => {
      this.products = products;
    })
  }
}
