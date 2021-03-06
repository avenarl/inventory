require 'rails_helper'

RSpec.describe 'Index of all Products page', type: :feature do
  it 'has a table of products' do
    create_list(:product, 5)
    product = create(:product, sku: 'SKU-001', name: 'Kobes')
    visit '/products'
    expect(page).to have_a_products_table
    expect(page).to have_products_with(count: 6)
    expect(page).to have_table_header_with(text: 'SKU')
    expect(page).to have_table_header_with(text: 'Name')
    expect(page).to have_table_header_with(text: 'Updated at')
    expect(page).to have_column_for('sku', value: 'SKU-001', record: product)
    expect(page).to have_column_for('name', value: 'Kobes', record: product)
    expect(page).to have_actions_of('Show', path: "/products/#{product.id}", record: product)
    expect(page).to have_actions_of('Edit', path: "/products/#{product.id}/edit", record: product)
    expect(page).to have_actions_of('Delete', path: "/products/#{product.id}", record: product)
  end

  private

  def have_a_products_table
    have_css('table#products-table')
  end

  def have_products_with(count:)
    have_css('table tbody tr', count: count)
  end

  def have_table_header_with(text:)
    have_css('table thead tr', text: text)
  end

  def have_column_for(name, value:, record:)
    have_css("table tbody tr#product--#{record.id} td#product--#{record.id}_#{name}", text: value)
  end

  def have_actions_of(title, path:, record:, **_params)
    within("table tbody tr#product--#{record.id} td#product--#{record.id}_actions") do
      have_link(title, href: path)
    end
  end
end
