package io.swagger.client.model




case class Variable (
  /* User-defined variable display name. */
  name: String,
  /* Name used when the variable was originally created in the `variables` table. */
  originalName: String,
  /* Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc. */
  category: String,
  /* Abbreviated name of the default unit for the variable */
  unit: String,
  /* Comma-separated list of source names to limit variables to those sources */
  sources: String,
  /* Minimum reasonable value for this variable (uses default unit) */
  minimumValue: Double,
  /* Maximum reasonable value for this variable (uses default unit) */
  maximumValue: Double,
  /* How to aggregate measurements over time. */
  combinationOperation: String,
  /* Value for replacing null measurements */
  fillingValue: Double)
  
