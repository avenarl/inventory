export class Product {
    id: number;
    name: string;
    isEditing?: boolean = false;
    
constructor(id: number, name: string) {
    this.id = id;
    this.name = name; 
  }
}