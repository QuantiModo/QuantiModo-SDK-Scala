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
  /* Minimum value permitted for this unit */
  minimum_value: Float,
  /* Maximum value permitted for this unit */
  maximum_value: Float,
  /* updated */
  updated: Integer,
  /* ID of default unit for this units category */
  default_unit_id: Integer,
  /* Value multiplied to convert to default unit in this unit category */
  multiply: Float,
  /* Value which should be added to convert to default unit */
  add: Float,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime)
  
