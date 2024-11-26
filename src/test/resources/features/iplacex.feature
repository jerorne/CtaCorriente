Feature: Búsqueda y visualización de carrera en el sitio de IPLACEX
  Como usuario del sitio web de IPLACEX
  Quiero buscar la carrera de Ingeniería en Informática
  Para obtener información detallada sobre esa carrera

  Scenario: Buscar y visualizar información de Ingeniería en Informática
    Given que estoy en la página principal de IPLACEX
    And hago clic en el enlace "Ver Carreras"
    And hago clic en el campo de búsqueda de carreras
    And escribo "Ingeniería en Informática" en el campo de búsqueda
    And presiono Enter para realizar la búsqueda
    Then debería ver los resultados de la carrera "Ingeniería en Informática"
    When hago clic en el enlace "Ver carrera" de Ingeniería en Informática
    Then debería ver la página con información detallada de la carrera
