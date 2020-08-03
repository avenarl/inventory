class Warehouse < ApplicationRecord
  has_many :stocks, dependent: :destroy
  has_many :products, -> { distinct }, through: :stocks
  has_many :orders
  
  validates :city, presence: true
  validates :province, presence: true
end
