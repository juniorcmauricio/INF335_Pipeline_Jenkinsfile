package br.unicamp.ic.inf335.beans.inf335_trabalho04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

class AnuncianteBeanTest {

    private AnuncianteBean anunciante;

    @BeforeEach // Roda antes de cada teste para garantir um estado limpo
    void setUp() {
        anunciante = new AnuncianteBean("Fulano", "123456789-00", new ArrayList<>());
    }

    @Test
    void testAdicionarEListarAnuncios() {
        ProdutoBean produto = new ProdutoBean("001", "Produto A", "Desc A", 100.0, "Novo");
        AnuncioBean anuncio = new AnuncioBean(produto, null, 0.1);

        anunciante.addAnuncio(anuncio);

        assertEquals(1, anunciante.getAnuncios().size(), "A lista de anúncios deveria ter 1 item");
    }
    

    @Test
    void testAdicionarEListarAnuncios_2() {
        ProdutoBean produto1 = new ProdutoBean("001", "Produto A", "Desc A", 100.0, "Novo");
        AnuncioBean anuncio1 = new AnuncioBean(produto1, null, 0.1);
        ProdutoBean produto2 = new ProdutoBean("001", "Produto A", "Desc A", 100.0, "Novo");
        AnuncioBean anuncio2 = new AnuncioBean(produto2, null, 0.1);

        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);

        assertEquals(2, anunciante.getAnuncios().size(), "A lista de anúncios deveria ter 2 itens");
    }

    @Test
    void testRemoverAnuncio() {
        ProdutoBean p1 = new ProdutoBean("001", "Produto A", "Desc A", 100.0, "Novo");
        AnuncioBean a1 = new AnuncioBean(p1, null, 0.0);
        ProdutoBean p2 = new ProdutoBean("002", "Produto B", "Desc B", 200.0, "Novo");
        AnuncioBean a2 = new AnuncioBean(p2, null, 0.0);

        anunciante.addAnuncio(a1);
        anunciante.addAnuncio(a2);

        anunciante.removeAnuncio(0); // Remove o primeiro anúncio

        assertEquals(1, anunciante.getAnuncios().size(), "A lista de anúncios deveria ter 1 item após a remoção");
        assertEquals("002", anunciante.getAnuncios().get(0).getProduto().getCodigo(), "O anúncio restante deveria ser o do Produto B");
    }

    @Test
    void testValorMedioAnuncios() {
        // Cenário: 3 anúncios com valores (já com desconto) de 90, 150 e 300
        ProdutoBean p1 = new ProdutoBean("001", "P1", "", 100.0, "Novo");
        AnuncioBean a1 = new AnuncioBean(p1, null, 0.1); // Valor = 90
        ProdutoBean p2 = new ProdutoBean("002", "P2", "", 200.0, "Novo");
        AnuncioBean a2 = new AnuncioBean(p2, null, 0.25); // Valor = 150
        ProdutoBean p3 = new ProdutoBean("003", "P3", "", 300.0, "Novo");
        AnuncioBean a3 = new AnuncioBean(p3, null, 0.0); // Valor = 300

        anunciante.addAnuncio(a1);
        anunciante.addAnuncio(a2);
        anunciante.addAnuncio(a3);

        Double mediaEsperada = (90.0 + 150.0 + 300.0) / 3.0;

        assertEquals(mediaEsperada, anunciante.valorMedioAnuncios(), "A média dos valores dos anúncios está incorreta");
    }

    @Test
    void testValorMedioAnunciosSemAnuncios() {
         // Cenário de Borda: O que acontece se não houver anúncios?
         // Deve retornar 0 e não quebrar (ex: divisão por zero).
         assertEquals(0.0, anunciante.valorMedioAnuncios(), "A média para um anunciante sem anúncios deveria ser 0.0");
    }
}