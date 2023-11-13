package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BibliotecaTest {
    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testPesquisaPorTitulo() {
        // Simule a entrada do usuário
        String input = "Livro 1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Biblioteca biblioteca = new Biblioteca();

        // Chame o método de pesquisa
        biblioteca.pesquisaPorTitulo();

        // Verifique a saída
        String expectedOutput = "Digite o título da obra que deseja pesquisar: Resultado da pesquisa por título: Livro 1\r\n" + //

                "Tipo: Livro\r\n" + //

                "Título: Livro 1\r\n" + //

                "Autor: Autor 1\r\n" + //

                "Ano de Publicação: 2000\r\n" + //

                "Exemplares Disponíveis: 3";

        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim(), outputContent.toString().trim());
    }

    @Test
    public void testPesquisaPorTituloArquivo() {
        Biblioteca biblioteca = new Biblioteca();

        // Chame o método de pesquisa no arquivo com um título de pesquisa específico
        biblioteca.pesquisaPorTituloArquivo("livros.txt", "Livro 2", "Livro");

        // Verifique a saída esperada
        String expectedOutput = "Tipo: Livro\n" +
                "Título: Livro 2\n" +
                "Autor: Autor 2\n" +
                "Ano de Publicação: 2001\n" +
                "Exemplares Disponíveis: 2\n";
        // Remova espaços em branco extras e caracteres de nova linha antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));

    }

    @Test
    void testPesquisaPorAutor() {
        // Simule a entrada do usuário
        String input = "Autor 1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Biblioteca biblioteca = new Biblioteca();

        // Chame o método de pesquisa
        biblioteca.pesquisaPorAutor();

        // Verifique a saída
        String expectedOutput = "Digite o nome do autor que deseja pesquisar: Resultado da pesquisa por autor: Autor 1\r" + 

                "Tipo: Livro\r\n" + //

                "Título: Livro 1\r\n" + //

                "Autor: Autor 1\r\n" + //

                "Ano de Publicação: 2000\r\n" + //

                "Exemplares Disponíveis: 3\r\n" + 
                "\r\n" +
                "Tipo: Revista\r\n" + //

                "Título: Revista 1\r\n" + //

                "Autor: Autor 1\r\n" + //

                "Ano de Publicação: 2003\r\n" + //

                "Exemplares Disponíveis: 3\r\n" + 
                "\r\n" +
                "Tipo: Tese\r\n" + //

                "Título: Tese 1\r\n" + //

                "Autor: Autor 1\r\n" + //

                "Ano de Publicação: 2006\r\n" + //

                "Exemplares Disponíveis: 3\r\n" + 
                "\r\n" +
                "Tipo: CD\r\n" + //

                "Título: CD 1\r\n" + //

                "Autor: Autor 1\r\n" + //

                "Ano de Publicação: 2009\r\n" + //

                "Exemplares Disponíveis: 3\r\n" + 
                "\r\n" + 
                "Tipo: DVD\r\n" + //

                "Título: DVD 1\r\n" + //

                "Autor: Autor 1\r\n" + //

                "Ano de Publicação: 2012\r\n" + //
                
                "Exemplares Disponíveis: 2";

        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim(), outputContent.toString().trim());

    }

    @Test
    void testPesquisaPorAutorArquivo() {
        Biblioteca biblioteca = new Biblioteca();

        // Chame o método de pesquisa no arquivo com um título de pesquisa específico
        biblioteca.pesquisaPorAutorArquivo("livros.txt", "Autor 1", "Livro");
        biblioteca.pesquisaPorAutorArquivo("revistas.txt", "Autor 1", "Revista");

        // Verifique a saída esperada
        String expectedOutput = "Tipo: Livro\n" +
                "Título: Livro 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2000\n" +
                "Exemplares Disponíveis: 3\n" +
                "Tipo: Revista\n" +
                "Título: Revista 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2003\n" +
                "Exemplares Disponíveis: 3\n";
        // Remova espaços em branco extras e caracteres de nova linha antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

    @Test
    void testPesquisaPorAno() {
        // Simule a entrada do usuário
        String input = "2000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Biblioteca biblioteca = new Biblioteca();

        // Chame o método de pesquisa
        biblioteca.pesquisaPorAnoPublicacao();

        // Verifique a saída
        String expectedOutput = "Digiteoanodepublicaçãoquedesejapesquisar:Resultadodapesquisaporanodepublicação:2000Tipo:LivroTítulo:Livro1Autor:Autor1AnodePublicação:2000ExemplaresDisponíveis:3";

        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));

    }

    @Test
    void testPesquisaPorAnoArquivo() {
        Biblioteca biblioteca = new Biblioteca();

        // Chame o método de pesquisa no arquivo com um título de pesquisa específico
        biblioteca.pesquisaPorAnoPublicacaoArquivo("livros.txt", 2000, "Livro");
        biblioteca.pesquisaPorAnoPublicacaoArquivo("revistas.txt", 2000, "Revista");

        // Verifique a saída esperada
        String expectedOutput = "Tipo: Livro\n" +
                "Título: Livro 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2000\n" +
                "Exemplares Disponíveis: 3\n";
        // Remova espaços em branco extras e caracteres de nova linha antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

    @Test
    void testPesquisaTipoLivro() {

        // Crie uma instância da biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Caminho do arquivo para o teste
        String filePath = "livros.txt";

        // Chame o método de pesquisa
        biblioteca.pesquisaTipoLivro(filePath);

        // Verifique a saída
        String expectedOutput = "Livros em ordem alfabética por título:\n" +
                "Título: Livro 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2000\n" +
                "Exemplares Disponíveis: 3\n" +

                "Título: Livro 2\n" +
                "Autor: Autor 2\n" +
                "Ano de Publicação: 2001\n" +
                "Exemplares Disponíveis: 2\n" +

                "Título: Livro 3\n" +
                "Autor: Autor 3\n" +
                "Ano de Publicação: 2002\n" +
                "Exemplares Disponíveis: 2\n";
        // Remova espaços em branco extras e caracteres de nova linha antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

    @Test
    void testPesquisaTipoRevista() {
        Biblioteca biblioteca = new Biblioteca();

        // Caminho do arquivo para o teste
        String filePath = "revistas.txt";

        // Chame o método de pesquisa
        biblioteca.pesquisaTipoRevista(filePath);

        // Verifique a saída esperada
        String expectedOutput = "Revistas em ordem alfabética por título:\n" +
                "Título: Revista 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2003\n" +
                "Exemplares Disponíveis: 3\n" +
                "Título: Revista 2\n" +
                "Autor: Autor 2\n" +
                "Ano de Publicação: 2004\n" +
                "Exemplares Disponíveis: 3\n" +
                "Título: Revista 3\n" +
                "Autor: Autor 3\n" +
                "Ano de Publicação: 2005\n" +
                "Exemplares Disponíveis: 3\n";
        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

    @Test
    void testPesquisaTipoTese() {
        Biblioteca biblioteca = new Biblioteca();

        // Caminho do arquivo para o teste
        String filePath = "teses.txt";

        // Chame o método de pesquisa
        biblioteca.pesquisaTipoTese(filePath);

        // Verifique a saída esperada
        String expectedOutput = "Teses em ordem alfabética por título:\n" +
                "Título: Tese 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2006\n" +
                "Exemplares Disponíveis: 3\n" +
                "Título: Tese 2\n" +
                "Autor: Autor 2\n" +
                "Ano de Publicação: 2007\n" +
                "Exemplares Disponíveis: 3\n" +
                "Título: Tese 3\n" +
                "Autor: Autor 3\n" +
                "Ano de Publicação: 2008\n" +
                "Exemplares Disponíveis: 3\n";
        ;
        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

    @Test
    void testPesquisaTipoCD() {
        Biblioteca biblioteca = new Biblioteca();

        // Caminho do arquivo para o teste
        String filePath = "cds.txt";

        // Chame o método de pesquisa
        biblioteca.pesquisaTipoCD(filePath);

        // Verifique a saída esperada
        String expectedOutput = "CDs em ordem alfabética por título:\n" +
                "Título: CD 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2009\n" +
                "Exemplares Disponíveis: 3\n" +
                "Título: CD 2\n" +
                "Autor: Autor 2\n" +
                "Ano de Publicação: 2010\n" +
                "Exemplares Disponíveis: 3\n" +
                "Título: CD 3\n" +
                "Autor: Autor 3\n" +
                "Ano de Publicação: 2011\n" +
                "Exemplares Disponíveis: 3\n";
        ;
        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

    @Test
    void testPesquisaTipoDVD() {
        Biblioteca biblioteca = new Biblioteca();
        // Caminho do arquivo para o teste
        String filePath = "dvds.txt";

        // Chame o método de pesquisa
        biblioteca.pesquisaTipoDVD(filePath);

        // Verifique a saída esperada
        String expectedOutput = "DVDs em ordem alfabética por título:\n" +
                "Título: DVD 1\n" +
                "Autor: Autor 1\n" +
                "Ano de Publicação: 2012\n" +
                "Exemplares Disponíveis: 2\n" +
                "Título: DVD 2\n" +
                "Autor: Autor 2\n" +
                "Ano de Publicação: 2013\n" +
                "Exemplares Disponíveis: 2\n" +
                "Título: DVD 3\n" +
                "Autor: Autor 3\n" +
                "Ano de Publicação: 2014\n" +
                "Exemplares Disponíveis: 2\n";
        // Remova espaços em branco extras antes de comparar
        assertEquals(expectedOutput.trim().replaceAll("\\s+", ""),
                outputContent.toString().trim().replaceAll("\\s+", ""));
    }

}