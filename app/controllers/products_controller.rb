class ProductsController < ApplicationController
  def index
    @products = Product.all
  end

  # Private methods means that it can't be accessed by users
  # Not accessible via any routes
  private

  # Method parameters: GET / POST request
  def products_params
    params.require(:product).permit(:name, :sku)
  end
end
