Rails.application.routes.draw do

  resources :products, only: %i[index show edit destroy new create]
  devise_for :users
  root to: "pages#homepage"
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
