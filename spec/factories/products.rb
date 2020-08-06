FactoryBot.define do
  factory :product do
    sku { rand(1000..5000) }
    name { Faker::Device.model_name }
  end
end
