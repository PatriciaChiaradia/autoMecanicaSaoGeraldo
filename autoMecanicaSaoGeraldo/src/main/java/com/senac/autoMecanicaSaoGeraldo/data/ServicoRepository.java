
package com.senac.autoMecanicaSaoGeraldo.data;

import com.senac.autoMecanicaSaoGeraldo.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Integer>{
    
}
