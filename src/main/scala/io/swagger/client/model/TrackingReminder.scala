package io.swagger.client.model

import org.joda.time.DateTime



case class TrackingReminder (
  /* id */
  id: Integer,
  /* client_id */
  client_id: String,
  /* ID of User */
  user_id: Integer,
  /* Id for the variable to be tracked */
  variable_id: Integer,
  /* Default value to use for the measurement when tracking */
  default_value: Float,
  /* Earliest time of day at which reminders should appear */
  reminder_start_time: String,
  /* Latest time of day at which reminders should appear */
  reminder_end_time: String,
  /* String identifier for the sound to accompany the reminder */
  reminder_sound: String,
  /* Number of seconds between one reminder and the next */
  reminder_frequency: Integer,
  /* True if the reminders should appear as a popup notification */
  pop_up: Boolean,
  /* True if the reminders should be delivered via SMS */
  sms: Boolean,
  /* True if the reminders should be delivered via email */
  email: Boolean,
  /* True if the reminders should appear in the notification bar */
  notification_bar: Boolean,
  /* ISO 8601 timestamp for the last time a reminder was sent */
  last_reminded: DateTime,
  /* ISO 8601 timestamp for the last time a measurement was received for this user and variable */
  last_tracked: DateTime,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime)
  
