package codingtest.test;

public enum Level {
    HIGH(1) {
		@Override
		public String normalize() {
			return HIGH.toString().toLowerCase();
		}
    },  
    MEDIUM(2) {
        @Override
        public String normalize() {
            return MEDIUM.toString().toLowerCase()+MEDIUM.toString().toUpperCase();
        }
    },
    LOW(3) {
        @Override
        public String normalize() {
            return LOW.toString().toUpperCase();
        }
    };

    private int intValue;

    private Level(int val) {
        intValue = val;
    }

    public int getLevel() {
        return intValue;
    }

    public abstract String normalize();
}
