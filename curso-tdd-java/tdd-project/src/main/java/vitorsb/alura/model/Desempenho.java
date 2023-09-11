package vitorsb.alura.model;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.20");
        }
    },
    INDEFINIDO {
        @Override
        public BigDecimal percentualReajuste() {
            return BigDecimal.ZERO;
        }
    };


    public abstract BigDecimal percentualReajuste();
}
