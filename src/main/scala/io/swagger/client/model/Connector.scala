package io.swagger.client.model




case class Connector (
  /* Connector ID number */
  id: Integer,
  /* Connector lowercase system name */
  name: String,
  /* Connector pretty display name */
  display_name: String,
  /* URL to the image of the connector logo */
  image: String,
  /* URL to a site where one can get this device or application */
  get_it_url: String,
  /* Short description */
  short_description: String,
  /* Long description */
  long_description: String,
  /* enabled */
  enabled: Boolean,
  /* oauth */
  oauth: Boolean)
  
