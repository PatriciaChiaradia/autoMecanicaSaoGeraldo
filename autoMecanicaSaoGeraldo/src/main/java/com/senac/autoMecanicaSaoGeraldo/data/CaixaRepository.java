
package com.senac.autoMecanicaSaoGeraldo.data;

import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Integer> {
    
}
