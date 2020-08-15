class ProductsController < ApplicationController
  def index
    @products = Product.all
  end

  def show
  end

  def edit
  end

  def destroy
    @product.destroy!

    flash.notice = "Successfully deleted product #{@product.id}!"
    redirect_to products_path
  end

  def new
    @product = Product.new
  end

  def create
    @product = Product.new(product_params)
    if @product.save
      flash.notice = 'Successfully created a product!'
      redirect_to product_path(@product)
    else
      render :new
    end
  end

  def update
    if @product.update(product_params)
      flash.notice = 'Successfully updated the product'
      redirect_to product_path(@product)
    else
      render :edit
    end
  end
  # Private methods means that it can't be accessed by users
  # Not accessible via any routes
  private

  # Method parameters: GET / POST request
  def products_params
    params.require(:product).permit(:name, :sku)
  end
end
