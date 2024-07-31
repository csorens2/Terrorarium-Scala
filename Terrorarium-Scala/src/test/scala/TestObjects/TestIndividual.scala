package TestObjects

import GeneticAlgorithm.{Chromosome, Individual}

object TestIndividual {
  def Create(chromosome: Chromosome): Individual =
    Individual(Create, chromosome, 0.0)

  def NewIndividual(): Individual =
    Create(Chromosome(Vector.empty))
}
