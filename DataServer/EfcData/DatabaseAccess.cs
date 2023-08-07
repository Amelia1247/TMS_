using EfcData.Entities;
using Microsoft.EntityFrameworkCore;

namespace EfcData; 

public class DatabaseAccess : DbContext {
    public DbSet<UserEntity> Users { get; set; }
    public DbSet<PlayerEntity> Players { get; set; }
    public DbSet<TeamEntity> Teams { get; set; }
    
    public DbSet<TournamentInfoEntity> TournamentInfo { get; set; }

    public DbSet<TournamentEntity> Tournaments { get; set; }

    
    protected override async void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Data Source = ../EfcData/DB.db");
    }
}