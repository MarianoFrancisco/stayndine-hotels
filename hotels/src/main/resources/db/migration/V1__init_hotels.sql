CREATE TABLE IF NOT EXISTS hotel (
    id            BINARY(16)   NOT NULL,
    code          VARCHAR(40)  NOT NULL,
    name          VARCHAR(180) NOT NULL,
    description   TEXT         NULL,
    country       VARCHAR(60)  NOT NULL,
    state         VARCHAR(60)  NULL,
    city          VARCHAR(80)  NOT NULL,
    address_line1 VARCHAR(160) NOT NULL,
    address_line2 VARCHAR(160) NULL,
    postal_code   VARCHAR(20)  NULL,
    phone         VARCHAR(40)  NULL,
    email         VARCHAR(120) NULL,
    timezone      VARCHAR(60)  NOT NULL DEFAULT 'UTC',
    star_rating   TINYINT      NULL,
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_hotel_code (code)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS room_type (
    id                BINARY(16)   NOT NULL,
    hotel_id          BINARY(16)   NOT NULL,
    code              VARCHAR(40)  NOT NULL,
    name              VARCHAR(120) NOT NULL,
    description       TEXT         NULL,
    capacity_adults   TINYINT      NOT NULL DEFAULT 2,
    capacity_children TINYINT      NOT NULL DEFAULT 0,
    total_units       INT          NOT NULL DEFAULT 1,
    base_price        DECIMAL(10,2) NOT NULL, -- precio por noche base
    created_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_rt_hotel_code (hotel_id, code),
    KEY idx_rt_hotel (hotel_id),
    CONSTRAINT fk_rt_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS seasonal_price (
    id           BINARY(16)  NOT NULL,
    room_type_id BINARY(16)  NOT NULL,
    start_date   DATE        NOT NULL,
    end_date     DATE        NOT NULL,
    price        DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (id),
    KEY idx_sp_rt (room_type_id),
    KEY idx_sp_range (start_date, end_date),
    CONSTRAINT fk_sp_rt FOREIGN KEY (room_type_id) REFERENCES room_type(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
