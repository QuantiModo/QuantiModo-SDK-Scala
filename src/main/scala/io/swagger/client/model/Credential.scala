package io.swagger.client.model

import org.joda.time.DateTime



case class Credential (
  /* connector_id */
  connector_id: Integer,
  /* attr_key */
  attr_key: String,
  /* attr_value */
  attr_value: String,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
