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
  newProductName: string = '';
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

  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(() => {
      this.getProducts();
    })
  }

  // For Update method
  updateProduct(id: number, product: Product) {
    if(product.isEditing){
      this.productService.updateProduct(product.id, product).subscribe(() => {
        product.isEditing = false;
        this.getProducts();
      }, error => {
        console.log(error);
      });
      
    }
  }

  enableEditing(product: Product) {
    this.products.forEach(p => p.isEditing = false);
    product.isEditing = true;
  }

  cancelEditing(product: Product) {
    product.isEditing = false;
  }

  addProduct() {
    const product: Partial<Product> = {
      name: this.newProductName,
      isEditing: false
    }
    this.productService.addProduct(product as Product).subscribe(() => {
      this.newProductName = '';
      this.getProducts();
    }, error => {
      console.log(error);
    });
  }
}
