package com.svar_proekt.weldproject.dto;

import com.svar_proekt.weldproject.model.ProductionObject;

public class ItamDTO {
    public ItamDTO() {
    }

    public ItamDTO(String name, ProductionObjectDTO productionObjectDTO) {
            this.name = name;
            this.productionObjectDTO = productionObjectDTO;
        }

        private int id;


        private String name;


        private ProductionObjectDTO productionObjectDTO;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ProductionObjectDTO getProductionObjectDTO() {
            return productionObjectDTO;
        }

        public void setProductionObjectDTO(ProductionObjectDTO productionObjectDTO) {
            this.productionObjectDTO = productionObjectDTO;
        }
    }

