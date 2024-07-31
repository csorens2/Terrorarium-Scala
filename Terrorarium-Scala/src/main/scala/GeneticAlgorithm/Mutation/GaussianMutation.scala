package GeneticAlgorithm.Mutation

import GeneticAlgorithm.Chromosome

import scala.util.Random

object GaussianMutation {
  def Mutate(chance: Double, coeff: Double, child: Chromosome): Chromosome =
    if chance < 0.0 || 1.0 < chance then
      throw new IllegalArgumentException("Illegal chance to mutate.")
    else
      val mutatedGenes =
        child.Genes.map(gene =>
          val sign =
            if Random.nextBoolean() then
              -1.0
            else
              1.0
          if Random.nextDouble() <= chance then
            gene + (sign * coeff * Random.nextDouble())
          else
            gene)
      Chromosome(mutatedGenes)
}
