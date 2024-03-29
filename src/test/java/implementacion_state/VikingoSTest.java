package implementacion_state;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VikingoSTest {

    VikingoS vikingo1;
    VikingoS vikingo2;

    @Before
    public void crearVikingos() {
        // Arrange
        vikingo1 = new VikingoS("Ragnar");
        vikingo2 = new VikingoS("Rollo");
    }

    @Test
    public void cuandoEsAtacadoUnaVez_PasaAColerico() {
        // Act
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 90);
        assertTrue(vikingo2.getEstado() instanceof Colerico);
    }

    @Test
    public void cuandoEsAtacadoDosVeces_PasaABerserker() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 70);
        assertTrue(vikingo2.getEstado() instanceof Berserker);
    }

    @Test
    public void cuandoEsAtacadoSiendoBerserker_SigueEnBerserker() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 65);
        assertTrue(vikingo2.getEstado() instanceof Berserker);
    }

    @Test
    public void cuandoEsAtacadoYLaVidaLlegaACero_MuereYDejaDeRecibirDanio() {
        // Act
        while (vikingo2.getVida() > 0) {
            vikingo1.hacerDanio(vikingo2);
        }

        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 0);
        assertTrue(vikingo2.getEstado() instanceof Muerto);
    }

    @Test
    public void cuandoEstaNormalYMedita_PasaACalmadoYNoRecibeDanio() {
        // Act
        vikingo2.meditar();
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertTrue(vikingo2.getEstado() instanceof Calmado);
        assertEquals(vikingo2.getVida(), 100);
    }

    @Test
    public void cuandoEstaColericoYMedita_PasaANormal() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo2.meditar();

        // Assert
        assertTrue(vikingo2.getEstado() instanceof Normal);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaBerserkerYMedita_PasaANormal() {
        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);
        vikingo2.meditar();

        // Assert
        assertTrue(vikingo2.getEstado() instanceof Normal);
        assertEquals(vikingo2.getVida(), 70);
    }

    @Test
    public void cuandoEstaCalmadoYMedita_SigueEnCalmado() {
        // Act
        vikingo1.meditar();
        vikingo1.meditar();

        // Assert
        assertTrue(vikingo1.getEstado() instanceof Calmado);
    }

    @Test
    public void cuandoEstaCalmadoYHaceDanio_PasaANormal() {
        // Act
        vikingo1.meditar();
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertTrue(vikingo1.getEstado() instanceof Normal);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaEnNormalYHaceDanio_NoCambiaDeEstado() {
        // Act
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertTrue(vikingo1.getEstado() instanceof Normal);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaEnColericoYHaceDanio_NoCambiaDeEstado() {
        // Act
        vikingo2.hacerDanio(vikingo1);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertTrue(vikingo1.getEstado() instanceof Colerico);
        assertTrue(vikingo2.getEstado() instanceof Colerico);
        assertEquals(vikingo1.getVida(), 90);
        assertEquals(vikingo2.getVida(), 80);
    }

    @Test
    public void cuandoEstaEnBerserkerYHaceDanio_NoCambiaDeEstado() {
        // Act
        vikingo2.hacerDanio(vikingo1);
        vikingo2.hacerDanio(vikingo1);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertTrue(vikingo1.getEstado() instanceof Berserker);
        assertTrue(vikingo2.getEstado() instanceof Colerico);
        assertEquals(vikingo1.getVida(), 70);
        assertEquals(vikingo2.getVida(), 70);
    }

}
