SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ciudades](
	[codigoCiudad] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[codigoProvincia] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ciudades] ADD PRIMARY KEY CLUSTERED 
(
	[codigoCiudad] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ciudades]  WITH CHECK ADD  CONSTRAINT [fk_ciudades_codigoProvincia] FOREIGN KEY([codigoProvincia])
REFERENCES [dbo].[provincias] ([codigoProvincia])
GO
ALTER TABLE [dbo].[ciudades] CHECK CONSTRAINT [fk_ciudades_codigoProvincia]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[clientes](
	[ci] [varchar](10) NOT NULL,
	[nombre] [varchar](100) NULL,
	[direccion] [varchar](100) NULL,
	[provincia] [int] NULL,
	[ciudad] [int] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
ALTER TABLE [dbo].[clientes] ADD PRIMARY KEY CLUSTERED 
(
	[ci] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[clientes]  WITH CHECK ADD FOREIGN KEY([ciudad])
REFERENCES [dbo].[ciudades] ([codigoCiudad])
GO
ALTER TABLE [dbo].[clientes]  WITH CHECK ADD FOREIGN KEY([provincia])
REFERENCES [dbo].[provincias] ([codigoProvincia])
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[compras](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[codigoProveedor] [varchar](13) NULL,
	[total] [decimal](9, 2) NULL,
	[fecha] [varchar](20) NULL,
	[estado] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[compras] ADD PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[compras]  WITH CHECK ADD FOREIGN KEY([codigoProveedor])
REFERENCES [dbo].[proveedores] ([ruc])
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalleTransaccion](
	[idTransaccion] [int] NULL,
	[codigoProducto] [varchar](10) NULL,
	[cantidad] [varchar](100) NULL,
	[precio] [decimal](15, 2) NULL,
	[tipo] [int] NULL,
	[fecha] [varchar](20) NULL
) ON [PRIMARY]
GO


--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[permisos](
	[codigo] [int] IDENTITY(1,1) NOT NULL,
	[productos] [int] NULL,
	[clientes] [int] NULL,
	[proveedores] [int] NULL,
	[facturas] [int] NULL,
	[compras] [int] NULL,
	[kardex] [int] NULL,
	[provincias] [int] NULL,
	[ciudades] [int] NULL,
	[listaVentas] [int] NULL,
	[listaCompras] [int] NULL,
	[gestionUsuarios] [int] NULL,
	[creacionUsuarios] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[permisos] ADD  CONSTRAINT [PK_permisos] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persona](
	[codigo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[apellido] [varchar](100) NULL,
	[codigoCiudad] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[persona] ADD PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[productos](
	[codigo] [varchar](10) NOT NULL,
	[nombre] [varchar](100) NULL,
	[rucProveedor] [varchar](13) NULL,
	[stock] [int] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
ALTER TABLE [dbo].[productos] ADD PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[productos] ADD  CONSTRAINT [DEFAULT_productos_stock]  DEFAULT ((0)) FOR [stock]
GO
ALTER TABLE [dbo].[productos]  WITH CHECK ADD  CONSTRAINT [FK_productos_proveedores] FOREIGN KEY([rucProveedor])
REFERENCES [dbo].[proveedores] ([ruc])
GO
ALTER TABLE [dbo].[productos] CHECK CONSTRAINT [FK_productos_proveedores]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[proveedores](
	[ruc] [varchar](13) NOT NULL,
	[nombre] [varchar](100) NULL,
	[telefono] [varchar](100) NULL,
	[direccion] [varchar](100) NULL,
	[provincia] [int] NULL,
	[ciudad] [int] NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
ALTER TABLE [dbo].[proveedores] ADD PRIMARY KEY CLUSTERED 
(
	[ruc] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[proveedores]  WITH NOCHECK ADD  CONSTRAINT [FK_proveedores_ciudades] FOREIGN KEY([ciudad])
REFERENCES [dbo].[ciudades] ([codigoCiudad])
GO
ALTER TABLE [dbo].[proveedores] CHECK CONSTRAINT [FK_proveedores_ciudades]
GO
ALTER TABLE [dbo].[proveedores]  WITH NOCHECK ADD  CONSTRAINT [FK_proveedores_provincias] FOREIGN KEY([provincia])
REFERENCES [dbo].[provincias] ([codigoProvincia])
GO
ALTER TABLE [dbo].[proveedores] CHECK CONSTRAINT [FK_proveedores_provincias]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[provincias](
	[codigoProvincia] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[provincias] ADD PRIMARY KEY CLUSTERED 
(
	[codigoProvincia] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuarios](
	[usuario] [varchar](100) NOT NULL,
	[clave] [varchar](100) NOT NULL,
	[estado] [int] NOT NULL,
	[productos] [int] NOT NULL,
	[clientes] [int] NOT NULL,
	[proveedores] [int] NOT NULL,
	[facturas] [int] NOT NULL,
	[compras] [int] NOT NULL,
	[kardex] [int] NOT NULL,
	[provincias] [int] NOT NULL,
	[ciudades] [int] NOT NULL,
	[listaVentas] [int] NOT NULL,
	[listaCompras] [int] NOT NULL,
	[gestionUsuarios] [int] NOT NULL,
	[creacionUsuarios] [int] NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
ALTER TABLE [dbo].[usuarios] ADD  CONSTRAINT [PK_usuarios] PRIMARY KEY CLUSTERED 
(
	[usuario] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO

--------------------------------------------------------------------

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ventas](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[codigoCliente] [varchar](10) NULL,
	[total] [decimal](9, 2) NULL,
	[fecha] [varchar](20) NULL,
	[estado] [int] NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ventas] ADD PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ventas]  WITH CHECK ADD FOREIGN KEY([codigoCliente])
REFERENCES [dbo].[clientes] ([ci])
GO




