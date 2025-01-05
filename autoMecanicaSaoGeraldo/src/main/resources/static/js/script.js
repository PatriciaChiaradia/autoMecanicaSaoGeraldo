//VALIDAÇÃO CADASTRO DE CLIENTE:
function validarFormularioCliente() {
    let nome = document.forms["formCadastro"]["nome"].value;
    let cpf = document.forms["formCadastro"]["cpf"].value;
    let telefone = document.forms["formCadastro"]["telefone"].value;
    let modelo = document.forms["formCadastro"]["modelo"].value; 
    let placa = document.forms["formCadastro"]["placa"].value; 
    
    // Validação do nome
    if (nome === "") { 
        alert("Nome é obrigatório."); 
        return false; 
    }
    
    // Validação do CPF (exemplo simples de 11 dígitos) 
    if (cpf === "") { 
        alert("CPF é obrigatório."); 
        return false; 
    } 
       if (!/^\d{3}\.\d{3}\.\d{3}-\d{2}$/.test(cpf)) { 
        alert("CPF deve estar no formato ###.###.###-## e conter 11 digitos.");
        return false; 
    } 

    // Validação do telefone 
    if (telefone === "") { 
        alert("Telefone é obrigatório."); 
        return false; 
    }
    
    // Validação do modelo 
    if (modelo === "") { 
        alert("Modelo do veículo é obrigatório."); 
        return false; 
    } 
    
    // Validação da placa 
    if (placa === "") {
        alert("Placa do veículo é obrigatória."); 
        return false; 
    } 
    if (!/^[A-Z]{3}[0-9][A-Z][0-9]{2}$/.test(placa)) {
        alert("Placa deve estar no formato ABC1D23."); 
        return false; 
    }
    
    // Mensagem de sucesso 
    alert("Cliente cadastrado com sucesso!");
    return true;
}


//VALIDAÇÃO LIVRO CAIXA:
function validarFormularioCaixa() {
    let data = document.forms["formCadastroCaixa"]["data"].value;
    let descricao = document.forms["formCadastroCaixa"]["descricao"].value;
    let valor = document.forms["formCadastroCaixa"]["valor"].value;
    
    // Validação do data
    if (data === "") { 
        alert("Data é obrigatório."); 
        return false; 
    } 
       if (!/^\d{2}\/\d{2}\/\d{4}$/.test(data)) { 
        alert("Data deve estar no formato DD/MM/YYYY");
        return false; 
    } 
    
    // Validação do descrição
    if (descricao=== "") { 
        alert("Descrição é obrigatória."); 
        return false; 
   
    }
    
    //Validação de valor
    if (valor === "" || parseFloat(valor) <= 0) {
        alert("O valor deve ser maior que zero.");
        return false;
    }
    if (!/^\d+(\,\d{1,2})?$/.test(valor)) { 
        alert("Digite um valor válido. Valores válidos são números decimais com até duas casas decimais, por exemplo, 21,12."); 
        return false; }
    // Converter a vírgula para ponto para armazenar corretamente no backend 
    valor = valor.replace(',', '.'); 
    document.forms["formCadastroCaixa"]["valor"].value = valor;
    
    // Mensagem de sucesso 
    alert("Registro salvo com sucesso!");
    return true;
}

//VALIDAÇÃO ORDEM DE SERVIÇO:
function validarFormularioServico() {
    let data = document.forms["formCadastroServico"]["data"].value;
    let descricao = document.forms["formCadastroServico"]["descricao"].value;
    let valor = document.forms["formCadastroServico"]["valor"].value;

    // Validação do data
    if (data === "") { 
        alert("Data é obrigatório."); 
        return false; 
    } 
       if (!/^\d{2}\/\d{2}\/\d{4}$/.test(data)) { 
        alert("Data deve estar no formato DD/MM/YYYY");
        return false; 
    } 
    
    //Validação de descrição
    if (descricao === "") {
        alert("Descrição é obrigatória.");
        return false;
    }
    
    //Validação de valor
    if (valor === "" || parseFloat(valor) <= 0) {
        alert("O valor deve ser maior que zero.");
        return false;
    }
    if (!/^\d+(\,\d{1,2})?$/.test(valor)) { 
        alert("Digite um valor válido. Valores válidos são números decimais com até duas casas decimais, por exemplo, 21,12."); 
        return false; } 
    // Converter a vírgula para ponto para armazenar corretamente no backend 
    valor = valor.replace(',', '.'); 
    document.forms["formCadastroServico"]["valor"].value = valor;

    // Mensagem de sucesso 
    alert("Ordem de serviço criada com sucesso!");
    return true;
    }

    function validarFormularioAtualizacao() {
        let nome = document.forms["formCadastro"]["nome"].value;
        let cpf = document.forms["formCadastro"]["cpf"].value;
        let telefone = document.forms["formCadastro"]["telefone"].value;
        let modelo = document.forms["formCadastro"]["modelo"].value; 
        let placa = document.forms["formCadastro"]["placa"].value; 
        
        // Validação do nome
        if (nome === "") { 
            alert("Nome é obrigatório."); 
            return false; 
        }
        
        // Validação do CPF (exemplo simples de 11 dígitos) 
        if (cpf === "") { 
            alert("CPF é obrigatório."); 
            return false; 
        } 
        if (!/^\d{3}\.\d{3}\.\d{3}-\d{2}$/.test(cpf)) { 
            alert("CPF deve estar no formato ###.###.###-## e conter 11 digitos.");
            return false; 
        } 

        // Validação do telefone 
        if (telefone === "") { 
            alert("Telefone é obrigatório."); 
            return false; 
        }
        
        // Validação do modelo 
        if (modelo === "") { 
            alert("Modelo do veículo é obrigatório."); 
            return false; 
        } 
        
        // Validação da placa 
        if (placa === "") {
            alert("Placa do veículo é obrigatória."); 
            return false; 
        } 
        if (!/^[A-Z]{3}[0-9][A-Z][0-9]{2}$/.test(placa)) {
            alert("Placa deve estar no formato ABC1D23."); 
            return false; 
        }
        
        // Mensagem de sucesso 
        alert("Dados do cliente atualizados com sucesso!");
        return true;
    }
 
