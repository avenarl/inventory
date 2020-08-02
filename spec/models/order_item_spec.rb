require 'rails_helper'

RSpec.describe OrderItem, type: :model do

  describe 'validations' do
    subject(:order_item) { build(:order_item) }

    it { is_expected.to validate_numericality_of(:quantity).is_greater_than(0) }
  end
end
