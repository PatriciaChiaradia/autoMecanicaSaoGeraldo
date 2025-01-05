
package com.senac.autoMecanicaSaoGeraldo.data;

import com.senac.autoMecanicaSaoGeraldo.model.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Integer> {

    @Query("SELECT c.saldoTotal FROM Caixa c ORDER BY c.idCaixa DESC LIMIT 1")
    Double findUltimoSaldoTotal();
    
    @Query("SELECT SUM(CASE WHEN c.tipoLancamento = 'ENTRADA' THEN c.valor ELSE -c.valor END) FROM Caixa c") 
    Double findSaldoTotal();
}


