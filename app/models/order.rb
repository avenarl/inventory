class Order < ApplicationRecord
  belongs_to :warehouse

  validates :customer_name, presence: true
end
