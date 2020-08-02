require 'rails_helper'

RSpec.describe Order, type: :model do

  describe 'validations' do
    subject(:order) { build(:order) }

    it { is_expected.to validate_presence_of(:customer_name) }
  end

  describe 'callbacks' do
    describe 'before_validation' do
      describe '#assign_uuid' do
        it 'assigns a randomly generated uuid' do
          order = build(:order, uuid: nil)

          order.valid?

          expect(order.uuid.present?).to eq(true)
        end
      end
    end
  end
end
