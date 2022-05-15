USE [PreguntasYRespuestas]
GO
/****** Object:  Table [dbo].[categoria]    Script Date: 14/05/2022 8:39:49 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[categoria](
	[id] [int] NOT NULL IDENTITY(1,1),
	[descripcion] [varchar](100) NOT NULL,
	[nivel] [int] NOT NULL,
	[premio] [int] NOT NULL,
 CONSTRAINT [PK_categoria] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 85, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pregunta]    Script Date: 14/05/2022 8:39:49 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pregunta](
	[id] [int] NOT NULL IDENTITY(1,1),
	[descripcion] [varchar](100) NOT NULL,
	[id_categoria] [int] NOT NULL,
 CONSTRAINT [PK_pregunta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 85, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[respuesta]    Script Date: 14/05/2022 8:39:49 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[respuesta](
	[id] [int] NOT NULL IDENTITY(1,1),
	[descripcion] [varchar](100) NOT NULL,
	[id_pregunta] [int] NOT NULL,
	[valido] [bit] NOT NULL,
 CONSTRAINT [PK_respuesta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 85, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[pregunta]  WITH NOCHECK ADD  CONSTRAINT [FK_id_categoria] FOREIGN KEY([id_categoria])
REFERENCES [dbo].[categoria] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[pregunta] CHECK CONSTRAINT [FK_id_categoria]
GO
ALTER TABLE [dbo].[respuesta]  WITH NOCHECK ADD  CONSTRAINT [FK_id_pregunta] FOREIGN KEY([id_pregunta])
REFERENCES [dbo].[pregunta] ([id])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[respuesta] CHECK CONSTRAINT [FK_id_pregunta]
GO
