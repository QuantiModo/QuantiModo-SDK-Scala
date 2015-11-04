package io.swagger.client.model

import org.joda.time.DateTime



case class Unit (
  /* id */
  id: Integer,
  /* client_id */
  client_id: String,
  /* Unit name */
  name: String,
  /* Unit abbreviation */
  abbreviated_name: String,
  /* Unit category ID */
  category_id: Integer,
  /* Unit minimum value */
  minimum_value: Float,
  /* Unit maximum value */
  maximum_value: Float,
  /* updated */
  updated: Integer,
  /* ID of default unit */
  default_unit_id: Integer,
  /* Value multiplied to */
  multiply: Float,
  /* Value which should be added to convert to default unit */
  add: Float,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
