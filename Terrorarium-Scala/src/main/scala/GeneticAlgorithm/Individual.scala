package GeneticAlgorithm

case class Individual(Create: Chromosome => Individual, chromosome: Chromosome, Fitness: Double)