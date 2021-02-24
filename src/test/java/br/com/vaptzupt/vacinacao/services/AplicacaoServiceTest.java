package br.com.vaptzupt.vacinacao.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.vaptzupt.vacinacao.models.Aplicacao;
import br.com.vaptzupt.vacinacao.models.Cliente;
import br.com.vaptzupt.vacinacao.repositories.IAplicacaoRepository;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AplicacaoServiceTest {
    BigDecimal mockedId = new BigDecimal(123123);
    BigDecimal notMockedId = new BigDecimal(312313);

    Cliente cliente = new Cliente(
        mockedId, "diogo@gmail.com", "09980980989080", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());

    Aplicacao aplicacaoComId = new Aplicacao(
        mockedId, cliente, "Cacildes", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
    Aplicacao aplicacaoSemId = new Aplicacao(
        cliente, "Cacildes", new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());

    @Mock
    private IAplicacaoRepository repository;

    @InjectMocks
    private AplicacaoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retornarTodasAsAplicacoesQuandoBuscarTodas() {
//        fail();
        when(repository.findAll())
            .thenReturn(Collections.singletonList(aplicacaoComId));

        List<Aplicacao> aplicacoes = service.buscarTodas();

        assertEquals(repository.findAll(), aplicacoes);
    }

    @Test
    void quandoBuscarPeloIdQueExisteRetornarItem() {

        when(repository.findById(mockedId))
            .thenReturn(Optional.ofNullable(aplicacaoComId));

        Optional<Aplicacao> aplic1 = service.buscarPeloId(mockedId);

        Aplicacao aplic1Get = null;

        // modo correto de usar o .get() verificando antes se existe objeto pelo .isPresent()
        if (aplic1.isPresent())
             aplic1Get = aplic1.get();

        // Existir uma entidade
        assertEquals(aplicacaoComId, aplic1Get);
    }

    @Test
    void deveLancarIllegalArgumentExceptionQuandoPassadoIdNull() {
        assertThrows(IllegalArgumentException.class, () -> service.buscarPeloId(null));
    }

    @Test
    void quandoBuscarPeloIdQueNaoExisteRetornarEmpty() {
        when(repository.findById(mockedId))
            .thenReturn(Optional.ofNullable(aplicacaoComId));

        Optional<Aplicacao> aplic1 = service.buscarPeloId(notMockedId);

        assertEquals(aplic1, Optional.empty());
    }

    @Test
    void deveRetornar1QuandoSalvarCorretamente() {
        when(repository.save(aplicacaoSemId))
            .thenReturn(aplicacaoComId);

//        Aplicacao savedAplic = service.save(aplicacaoSemId);
        int savedAplic = service.salvar(aplicacaoSemId);

//        assertNotEquals(savedAplic.getIdAplicacoes(), null);
        assertEquals(1, savedAplic);
    }

    @Test
    void deveLancarNullPointerExceptionQuandoPassadaEntidadeNull() {
        assertThrows(NullPointerException.class, () -> service.salvar(null));
    }

    @Test
    void deveAtualizarEntidade() {
//        fail();
        Aplicacao novAplic = aplicacaoComId;
        novAplic.setNomVacina("Bixo Pegando");

        when(repository.save(aplicacaoComId))
            .thenReturn(novAplic);

        int aplicSv = service.atualizar(aplicacaoComId);

        assertEquals(1, aplicSv);
    }

    @Test
    void deveDeletarObjetoPeloId() {
        when(repository.findById(mockedId))
            .thenReturn(Optional.ofNullable(aplicacaoComId));

        service.deletar(mockedId);

        verify(
            repository, times(1))
            .deleteById(eq(mockedId));


        when(repository.findById(mockedId))
            .thenReturn(Optional.empty());
        assertEquals(
            Optional.empty(), repository.findById(mockedId));
    }

    @Test
    void deveLancarEntityNotFoundExceptionQuandoIdNaoEValida() {
        when(repository.findById(notMockedId))
            .thenReturn(Optional.empty());



        assertThrows(EntityNotFoundException.class, () -> service.deletar(notMockedId));

    }
}