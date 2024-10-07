

Feature: Login al sistema y validacion del panel principal

  Yo como Alejandro,
  Quiero realizar una prueba de abrir una página
  Para comprobar la robustez y control de errores de la aplicación o página web.

  Background:
    Given "Alejandro" abre el navegador Microsoft Edge


  @successful
  Scenario: Abrir con el navegador Chrome la página web
    When    el usuario ingresa el Username y el Password
    Then visualizara el panel principal de la aplicacion
    When el usuario navega a la opción "Recruitment"
    And el usuario hace clic en el botón "Add"
    And llena el formulario de nuevo candidato con los datos:
      | Nombre      | Juan   |
      | Segundo Nombre | David  |
      | Apellido     | Carrillo |
      | Vacante      | Software Engineer |
      | Email        | juandavidcarrillogarcia@gmail.com |
      | Contacto     | 3152266755 |
    Then Validar el mensaje "Successfully Saved"
    And validar los datos en la pantalla "Application Stage":
      | First Name    | Juan      |
      | Middle        | David     |
      | Last Name     | Carrillo  |
      | Job Vacancy   | Software Engineer |
    Then scroll y validar los campos "Email" y "Contact Number":
      | Email         | juandavidcarrillogarcia@gmail.com |
      | Contacto      | 3152266755 |
    Then hacer scroll y hacer clic en el botón "Shortlist"
    Then validar el subtítulo "Shortlist Candidate"
    Then dar clic en la opción "Recruitment"
    Then validar el título "Candidates"
    Then hacer scroll hasta la información del candidato "Juan David Carrillo" y la vacante "Software Engineer"
    Then validar los datos "Juan David Carrillo" y "Software Engieer"









