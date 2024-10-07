

Feature: Login al sistema y validacion Gestion candidatos

  Yo como administrador
  Quiero poder agregar y gestionar los candidatos
  Para tener un registro adecuado de las postulaciones.  .

  Background:
    Given "Administrador" abre el navegador Microsoft Edge


  @successful
  Scenario: Agregar un Candidato
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









