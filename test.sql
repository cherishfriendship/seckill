
CREATE DATABASE seckill;

use seckill;

CREATE TABLE seckill (
  seckill_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  NAME VARCHAR(120) NOT NULL COMMENT '商品名称',
  number INT NOT NULL COMMENT '库存数量',
  start_time TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  end_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '秒杀结束时间',
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET =utf8 COMMENT='秒杀库存表';

INSERT into
  seckill(name,number,start_time,end_time)
values
  ('1000元秒杀iphone6',100,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
  ('500元秒杀ipad2',200,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
  ('300元秒杀小米4',300,'2015-11-01 00:00:00','2015-11-02 00:00:00'),
  ('200元秒杀红迷note',400,'2015-11-01 00:00:00','2015-11-02 00:00:00');

CREATE TABLE success_killed(
  seckill_id bigint not null COMMENT '秒杀商品id',
  user_phone bigint not null COMMENT '用户手机号',
  state tinyint not null DEFAULT -1 COMMENT '状态标示：-1：无效 0：成功 1：已付款',
  create_time TIMESTAMP not null COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
  key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET =utf8 COMMENT='秒杀成功明细表';

mysql -uroot -p1234