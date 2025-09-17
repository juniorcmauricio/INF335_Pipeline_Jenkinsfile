package br.unicamp.ic.inf335.beans.inf335_trabalho04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnuncioBeanTest {

    @Test
    void testGetValorComDesconto() {
        // Cenário: Produto de R$1000 com 20% de desconto
        ProdutoBean produto = new ProdutoBean("001", "Produto A", "Desc A", 1000.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 0.20); // 20% de desconto

        Double valorEsperado = 800.0; // 1000 * (1 - 0.2)
        Double valorCalculado = anuncio.getValor();

        assertEquals(valorEsperado, valorCalculado, "O valor com 20% de desconto deve ser 800.0");
    }

    @Test
    void testGetValorSemDesconto() {
        // Cenário: Produto de R$1500 com 0% de desconto
        ProdutoBean produto = new ProdutoBean("002", "Produto B", "Desc B", 1500.0, "Usado");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 0.0); // 0% de desconto

        assertEquals(1500.0, anuncio.getValor(), "O valor com 0% de desconto deve ser o valor original do produto");
    }

    @Test
    void testGetValorComDescontoTotal() {
        // Cenário: Produto de R$2000 com 100% de desconto
        ProdutoBean produto = new ProdutoBean("003", "Produto C", "Desc C", 2000.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 1.0); // 100% de desconto

        assertEquals(0.0, anuncio.getValor(), "O valor com 100% de desconto deve ser 0.0");
    }
}
