package implementacion_state;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VikingoSTest {

    @Test
    public void cuandoEsAtacadoUnaVez_SeVuelveColerico() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 90);
        assertTrue(vikingo2.getEstado() instanceof Colerico);
    }

    @Test
    public void cuandoEsAtacadoDosVeces_SeVuelveBerserker() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 70);
        assertTrue(vikingo2.getEstado() instanceof Berserker);
    }

    @Test
    public void cuandoEsAtacadoSiendoBerserker_SigueSiendoBerserker() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertEquals(vikingo2.getVida(), 65);
        assertTrue(vikingo2.getEstado() instanceof Berserker);
    }

    @Test
    public void cuandoEsAtacadoYLaVidaLlegaACero_Muere() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        while (vikingo2.getVida() > 0) {
            vikingo1.hacerDanio(vikingo2);
        }

        // Assert
        assertEquals(vikingo2.getVida(), 0);
        assertTrue(vikingo2.getEstado() instanceof Muerto);
    }

    @Test
    public void cuandoEstaCalmado_NoRecibeDanio() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        vikingo2.meditar();
        vikingo1.hacerDanio(vikingo2);

        // Assert
        assertTrue(vikingo2.getEstado() instanceof Calmado);
        assertEquals(vikingo2.getVida(), 100);
    }

    @Test
    public void cuandoEstaColericoYMedita_PasaANormal() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo2.meditar();

        // Assert
        assertTrue(vikingo2.getEstado() instanceof Normal);
        assertEquals(vikingo2.getVida(), 90);
    }

    @Test
    public void cuandoEstaBerserkerYMedita_PasaANormal() {
        // Arrange
        VikingoS vikingo1 = new VikingoS("Ragnar");
        VikingoS vikingo2 = new VikingoS("Rollo");

        // Act
        vikingo1.hacerDanio(vikingo2);
        vikingo1.hacerDanio(vikingo2);
        vikingo2.meditar();

        // Assert
        assertTrue(vikingo2.getEstado() instanceof Normal);
        assertEquals(vikingo2.getVida(), 70);
    }

}
