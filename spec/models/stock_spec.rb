require 'rails_helper'

RSpec.describe Stock, type: :model do

  describe 'validation' do
    subject(:stock) { build(:stock) }

    it { is_expected.to validate_presence_of(:count) }
    it { is_expected.to validate_numericality_of(:count).is_greater_than(0) }
  end
end
