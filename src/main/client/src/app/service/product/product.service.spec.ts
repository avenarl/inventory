import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ProductService } from './product.service';
import { Product } from 'src/app/model/product.model';

describe('ProductService', () => {
  let service: ProductService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProductService]
    });
    service = TestBed.inject(ProductService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should add a product', () => {
    const partialProduct: Partial<Product> = {
      name: 'Product 1',
    };
    
    const fullProduct: Product = {
      id: 1, 
      isEditing: false,
      name: partialProduct.name as string, 
    };
    
    service.addProduct(partialProduct).subscribe(data => {
      expect(data).toEqual(fullProduct);
    });
    
    const req = httpTestingController.expectOne('http://localhost:8080/api/v1/product/products');
    expect(req.request.method).toEqual('POST');
    req.flush(fullProduct);
  });
});

