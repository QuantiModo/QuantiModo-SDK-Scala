package io.swagger.client.model




case class User (
  /* User id */
  id: Integer,
  /* Wordpress user id */
  wpId: Integer,
  /* User display name */
  displayName: String,
  /* User login name */
  loginName: String,
  /* User email */
  email: String,
  /* User token */
  token: String,
  /* Is user administrator */
  administrator: Boolean)
  
