Feature: Inicio de Sesión

  Scenario: Ingreso de nombre de usuario con datos almacenados en BD
    Given el ejecutivo está en la página de inicio de sesión
    When el ejecutivo ingresa "12345678-9" y "password123"
    Then el ejecutivo debería ver la página principal

  Scenario: Ingreso de nombre de usuario y password con datos erróneos
    Given el ejecutivo está en la página de inicio de sesión
    When el ejecutivo ingresa "rut_invalido" y "password_invalido"
    Then el ejecutivo debería ver un mensaje de error

  Scenario: Registro de hora médica veterinaria
    Given el ejecutivo está en la página de registro de cita veterinaria
    When el ejecutivo ingresa los datos de la cita
    Then el sistema confirma el registro exitoso
	