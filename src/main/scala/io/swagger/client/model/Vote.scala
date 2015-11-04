package io.swagger.client.model

import org.joda.time.DateTime



case class Vote (
  /* id */
  id: Integer,
  /* client_id */
  client_id: String,
  /* ID of User */
  user_id: Integer,
  /* ID of cause variable */
  cause_id: Integer,
  /* ID of effect variable */
  effect_id: Integer,
  /* Value of Vote */
  value: Integer,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
