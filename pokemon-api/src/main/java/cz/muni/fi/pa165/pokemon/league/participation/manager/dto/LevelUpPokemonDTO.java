package cz.muni.fi.pa165.pokemon.league.participation.manager.dto;

import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * DTO for requests for increasing a Pokemon's level.
 * 
 * @author Tibor Zauko 433531
 */
public class LevelUpPokemonDTO {

    @NotNull
    private Long pokemonId;

    @NotNull
    private Long requestingTrainerId;

    @Min(1)
    @Max(100)
    private int newLevel;

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public Long getRequestingTrainerId() {
        return requestingTrainerId;
    }

    public void setRequestingTrainerId(Long requestingTrainerId) {
        this.requestingTrainerId = requestingTrainerId;
    }

    public int getNewLevel() {
        return newLevel;
    }

    public void setNewLevel(int newLevel) {
        this.newLevel = newLevel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.pokemonId);
        hash = 41 * hash + Objects.hashCode(this.requestingTrainerId);
        hash = 41 * hash + this.newLevel;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LevelUpPokemonDTO other = (LevelUpPokemonDTO) obj;
        if (this.newLevel != other.newLevel) {
            return false;
        }
        if (!Objects.equals(this.pokemonId, other.pokemonId)) {
            return false;
        }
        return Objects.equals(this.requestingTrainerId, other.requestingTrainerId);
    }

    @Override
    public String toString() {
        return "LevelUpPokemonDTO{" + "pokemonId=" + pokemonId + ", trainersId=" + requestingTrainerId + ", newLevel=" + newLevel + '}';
    }

}
